import {useState} from 'react'
import {Button, Form, Input, message, Steps} from 'antd';
import {Select} from 'antd';

const {Option} = Select;
const {Step} = Steps;

export default function AddApi() {

  // 当前步骤
  const [current, setCurrent] = useState(0);

  const next = () => {
    setCurrent(current + 1);
  };
  const prev = () => {
    setCurrent(current - 1);
  };

  const steps = [
    {
      title: '基本配置',
      content: <div>
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
            <Select defaultValue="get" style={{width: 120}}>
              <Option value="get">GET</Option>
              <Option value="post">POST</Option>
            </Select>
          </Form.Item>
        </Form>
      </div>,
    },
    {
      title: '请求参数',
      content: 'request-parameter',
    },
    {
      title: '结果测试',
      content: 'result-test',
    },
  ];


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
      padding: '30px 20px 10px 0px'
    }}>
      {steps[current].content}
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





