import React, {useEffect, useState} from 'react'
import {Avatar, Button, Form, Input, List, message, Select, Steps} from 'antd';
import Icon, {FieldStringOutlined, NumberOutlined} from '@ant-design/icons'
import {HColumn, HTable, queryColumn, queryTable} from "@/service/treeService";

const {Option} = Select;
const {Step} = Steps;

export default function AddApi() {

  // state
  // 当前步骤
  const [current, setCurrent] = useState(0);
  const [tables, setTables] = useState<HTable[]>();
  const [columns, setColumns] = useState<HColumn[]>();
  const [columnLoading, setColumnLoading] = useState(false);

  // hooks
  useEffect(() => {
    // 表
    queryTable().then(res => {
      const {data} = res
      // console.log('==3 res', data)
      setTables(data)
      if (data && data.length > 0) {
        // 字段（默认查询第一个表）
        refreshColumn(data[0].tableName)
      }
    })
  }, [])

  const refreshColumn = (tableName: string) => {
    setColumnLoading(true)
    queryColumn(tableName).then(res => {
      const {data} = res
      // console.log('==4 data', data)
      setColumns(data)
    }).finally(() => {
      setColumnLoading(false)
    })
  }

  // function
  const next = () => {
    setCurrent(current + 1);
  };
  const prev = () => {
    setCurrent(current - 1);
  };

  const steps = [
    {
      title: '基本配置',
    },
    {
      title: '请求参数',
    },
    {
      title: '结果测试',
    },
  ];

  const renderColumnItem = (item: any) => {
    const {dataType, columnName} = item;
    console.log(dataType)
    if (dataType === 'int' || dataType === 'bigint') {
      return <List.Item>
        <NumberOutlined style={{color: 'skyblue'}}/>
        <div style={{marginLeft: 3}}>{columnName}</div>
      </List.Item>
    } else if (dataType === 'varchar') {
      return <List.Item>
        <FieldStringOutlined style={{color: 'red'}}/>
        <span style={{marginLeft: 3}}>{columnName}</span>
      </List.Item>
    }

  }


  return <>
    {/* ==================== 步骤条 ==================== */}
    <Steps current={current}
           style={{
             marginBottom: 15,
           }}>
      {steps.map(item => (
        <Step key={item.title} title={item.title}/>
      ))}
    </Steps>
    {/* ==================== 步骤内容 ==================== */}
    <div style={{
      width: '100%',
      height: '80%',
      backgroundColor: 'rgba(250,250,250,1)',
      margin: '0px 0px 10px 0px',
      padding: '30px 20px 10px 20px'
    }}>
      {/* ============ 基本配置 ============ */}
      <div style={current !== 0 ? {display: 'none'} : {}}>
        <Form
          name="basicConfig"
          labelCol={{
            span: 5,
          }}
          wrapperCol={{
            span: 16,
          }}
          initialValues={{
            remember: true,
          }}
        >
          <Form.Item
            label="API名称"
            name="apiName"
            rules={[
              {
                required: true,
                message: '该项不得为空！'
              },
            ]}
          >
            <Input/>
          </Form.Item>
          <Form.Item
            label="请求方式"
            name="requestType"
            rules={[
              {
                required: true,
                message: '该项不得为空！'
              },
            ]}
          >
            {/* TODO 浏览器报错 */}
            <Select defaultValue="get" style={{width: 120}}>
              <Option value="get">GET</Option>
              <Option value="post">POST</Option>
            </Select>
          </Form.Item>
        </Form>
      </div>
      {/* ============ 请求参数配置 ============ */}
      <div style={current !== 1 ? {display: 'none'} : {}}>
        {/*== 选择表 ==*/}
        <Form name="requestParameter">
          <Form.Item label="表或视图" name="table">
            <Select style={{width: 120}} placeholder={"请选择表"}
                    onChange={(value) => {
                      refreshColumn(value + '')
                    }}>
              {tables?.map((item) => {
                return <Option key={item.tableName} value={item.tableName}>{item.tableName}</Option>
              })}
            </Select>
          </Form.Item>
        </Form>

        {/*== 选择字段 ==*/}
        <div style={{
          width: 198,
          height: 280,
          overflowY: 'auto',
        }}>
          <List itemLayout="horizontal" bordered={true} size={'small'}
                loading={columnLoading}
                dataSource={columns}
                renderItem={(item) => renderColumnItem(item)}
          />
        </div>
      </div>
      {/* ============ 测试结果 ============ */}
      <div style={current !== 2 ? {display: 'none'} : {}}>
      </div>
    </div>
    {/* ==================== 上一步/下一步 ==================== */}
    <div>
      {current < steps.length - 1 && (
        <Button type="primary" onClick={() => next()}>
          下一步
        </Button>
      )}
      {current === steps.length - 1 && (
        <Button type="primary" onClick={() => message.success('新建API流程完成！')}>
          完成
        </Button>
      )}
      {current > 0 && (
        <Button style={{margin: '0 8px'}} onClick={() => prev()}>
          上一步
        </Button>
      )}
    </div>
  </>
}




