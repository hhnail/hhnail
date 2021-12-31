import React from 'react'
import {HashRouter, Route, Switch} from 'react-router-dom'
import HomePage from "@/pages/HomePage";

export default function IndexPage() {
  return (
    <HashRouter>
      <Switch>
        <Route path="/" render={() => <HomePage />}/>
      </Switch>
    </HashRouter>
  )

}
