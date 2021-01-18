import React from 'react';
import {Switch, Route, BrowserRouter} from 'react-router-dom';
import Login from "./Login";
import Nav from "./Nav";
import Home from './Home'



const Main = () =>(
    <BrowserRouter>
        <Switch>
            <Route exact path='/login' component={Login}/>
            <Route exact path='/errore' render={(props) => <Login error={"Wrong Username or password"} {...props}/>} />
            <Route exact path='/' component={Home}/>
        </Switch>
    </BrowserRouter>
)


export default Main;