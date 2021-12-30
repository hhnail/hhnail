import React, {useState} from 'react'
import { Route, Switch} from 'react-router-dom'
import {Layout, Menu} from 'antd';
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  UploadOutlined,
  UserOutlined,
  VideoCameraOutlined,
} from '@ant-design/icons';
import styles from './index.less'



const {Header, Sider, Content} = Layout;

export default function IndexPage() {

  const [collapsed, setCollapsed] = useState(false)

  const toggle = () => {
    setCollapsed(!collapsed)
  };

  return (
    <Layout>

      <Sider trigger={null} collapsible collapsed={collapsed} style={{}}>
        <div className="logo"/>
        <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
          <Menu.Item key="1" icon={<UserOutlined/>}>
            导航1
          </Menu.Item>
          <Menu.Item key="2" icon={<VideoCameraOutlined/>}>
            导航2
          </Menu.Item>
          <Menu.Item key="3" icon={<UploadOutlined/>}>
            导航3
          </Menu.Item>
        </Menu>
      </Sider>



      <Layout className="site-layout">

        <Header className="site-layout-background" style={{padding: 0}}>
          {React.createElement(collapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
            className: 'trigger',
            onClick: toggle,
          })}
        </Header>

        <Content
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
          }}
        >
          <div style={{
            height:500,
            backgroundColor:"orange"
          }} className={styles.content}>

          </div>
        </Content>

      </Layout>
    </Layout>
  );
}
