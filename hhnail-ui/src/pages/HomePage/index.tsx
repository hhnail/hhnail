import React, {useState} from 'react'
import {useHistory, Route, Switch} from 'react-router-dom'
import {Layout, Menu} from 'antd';
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  UploadOutlined,
  UserOutlined,
  VideoCameraOutlined,
} from '@ant-design/icons';
import styles from './index.less'
import {ApiList} from "@/pages/HomePage/ApiList";


const {Header, Sider, Content} = Layout;


export default function HomePage() {

  const history = useHistory()

  const [collapsed, setCollapsed] = useState(false)

  const toggle = () => {
    setCollapsed(!collapsed)
  };

  return <>
    <Layout>
      {/*============================ 侧边栏 ============================*/}
      <Sider trigger={null} collapsible collapsed={collapsed} style={{}}>
        <div className="logo"/>
        <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
          <Menu.Item key="ApiList" icon={<UserOutlined/>}
                     onClick={() => {
                       history.push("ApiList")
                     }}>
            API列表
          </Menu.Item>
          <Menu.Item key="2" icon={<VideoCameraOutlined/>}>
            导航2
          </Menu.Item>
          <Menu.Item key="3" icon={<UploadOutlined/>}>
            导航3
          </Menu.Item>
        </Menu>
      </Sider>


      {/*============================ 页面内容 ============================*/}
      <Layout>

        <Header style={{padding: 0}}>
          {React.createElement(collapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
            className: 'trigger',
            onClick: toggle,
          })}
        </Header>

        <Content style={{
          margin: '24px 16px',
          padding: 24,
          minHeight: 280,
        }}
        >
          <Switch>
            <Route path="/ApiList" component={ApiList}/>
          </Switch>
        </Content>
      </Layout>
    </Layout>
  </>
}
