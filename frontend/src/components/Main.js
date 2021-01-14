import React from 'react';
import {Switch, Route, BrowserRouter} from 'react-router-dom';
import Login from "./Login";
import Nav from "./Nav";



const Main = () =>(
    <BrowserRouter>
        <Nav/>
        <Switch>
            <Route exact path='/' component={Login}/>
        </Switch>
    </BrowserRouter>
)


export default Main;