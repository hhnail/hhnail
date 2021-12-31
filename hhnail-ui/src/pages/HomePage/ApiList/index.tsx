import {Table, Tag, Space} from 'antd';
import {Tree, Row, Col} from 'antd';
import {useEffect} from "react";
import axios from 'axios'

// 解构组件
const {DirectoryTree} = Tree;

// 模拟数据
const treeData = [
  {
    title: 'apigroup1',
    key: 1,
    children: [
      {
        title: 'apigroup1-1',
        key: 11,
        isLeaf: false,
        children: [
          {
            title: 'apigroup1-1-1',
            key: 111,
            isLeaf: true,
          },
          {
            title: 'apigroup1-1-2',
            key: 112,
            isLeaf: true,
          },
        ],
      },
    ],
  },
  {
    title: 'leaf 0-1',
    key: 2,
    isLeaf: true,
  },
];
const data = [
  {
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
];


// 暴露组件
export function ApiList() {

  // hooks
  useEffect(() => {
    axios.get(`/api01/queryTreeData`)
      .then(res => {
        console.log('==1 res:', res.data)
      })
      .catch(err => {
        console.log('==1 err:', err)
      })
  })

  // 表格字段结构
  const columns = [
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name',
      render: (text: string) => <a>{text}</a>,
    },
    {
      title: 'Age',
      dataIndex: 'age',
      key: 'age',
    },
    {
      title: 'Address',
      dataIndex: 'address',
      key: 'address',
    },
    {
      title: 'Tags',
      key: 'tags',
      dataIndex: 'tags',
      render: (tags: any) => (
        <>
          {tags.map((tag: any) => {
            let color = tag.length > 5 ? 'geekblue' : 'green';
            if (tag === 'loser') {
              color = 'volcano';
            }
            return (
              <Tag color={color} key={tag}>
                {tag.toUpperCase()}
              </Tag>
            );
          })}
        </>
      ),
    },
    {
      title: 'Action',
      key: 'action',
      render: (text: string, record: any) => (
        <Space size="middle">
          <a>Invite {record.name}</a>
          <a>Delete</a>
        </Space>
      ),
    },
  ];

  const onSelect = (keys: any, info: any) => {
    console.log('Trigger Select', keys, info);
  };

  const onExpand = () => {
    console.log('Trigger Expand');
  };


  return <>
    <Row style={{width: '100%'}}>
      <Col span={5}>
        <DirectoryTree
          multiple
          defaultExpandAll
          onSelect={onSelect}
          onExpand={onExpand}
          treeData={treeData}
        />
      </Col>
      <Col span={18} push={1}>
        <Table
          columns={columns}
          dataSource={data}
        />
      </Col>
    </Row>
  </>
}




