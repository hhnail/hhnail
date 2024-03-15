import React, {useState} from 'react'
import {useHistory, Route, Switch} from 'react-router-dom'
import {Layout, Menu} from 'antd';
import Icon, {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  UploadOutlined,
  UserOutlined,
  VideoCameraOutlined,
} from '@ant-design/icons';
import styles from './index.less'
// 自定义组件
import {ApiList} from "@/pages/HomePage/ApiList";
import AddApi from "@/pages/HomePage/ApiList/AddApi";
// 静态资源
import {ReactComponent as SmileIcon} from "../../../image/smile.svg";


const {Header, Sider, Content} = Layout;


export default function HomePage() {

  const history = useHistory()

  const [collapsed, setCollapsed] = useState(false)

  const toggle = () => {
    setCollapsed(!collapsed)
  };

  return <>
    <Layout style={{
      overflowY: "hidden",
      height: '100%',
    }}>
      {/*============================ 侧边栏 ============================*/}
      <Sider trigger={null} collapsible collapsed={collapsed} style={{}}>
        <div>
          <span
            style={{
              color: 'white',
              fontSize: 20,
              fontWeight: 2000,
            }}>hv-data</span>
          <Icon style={{
            fontSize: 60,
            width: 120,
            height: 90,
          }} component={SmileIcon}/>
        </div>
        <Menu theme="dark" mode="inline" defaultSelectedKeys={['ApiList']}>
          <Menu.Item key="ApiList" icon={<UserOutlined/>}
                     onClick={() => {
                       history.push("ApiList")
                     }}>
            API列表
          </Menu.Item>
          <Menu.Item key="2" icon={<VideoCameraOutlined/>}
                     onClick={() => {
                       history.push("AddApi")
                     }}>
            新建API
          </Menu.Item>
          <Menu.Item key="3" icon={<UploadOutlined/>} onClick={() => {
            history.push("ApiList")
          }}>
            导航3
          </Menu.Item>
        </Menu>
      </Sider>


      {/*============================ 页面内容 ============================*/}
      <Layout>

        <Header style={{padding: 0}}>
          {React.createElement(collapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
            className: 'trigger',
            style: {color: 'white'},
            onClick: toggle,
          })}
        </Header>

        <Content style={{
          padding: 24,
          height: 540,
          width: 998,
          overflowY: "auto",
        }}>
          <Switch>
            <Route path="/ApiList" component={ApiList}/>
            <Route path="/AddApi" component={AddApi}/>
          </Switch>
        </Content>
      </Layout>
    </Layout>
  </>
}
