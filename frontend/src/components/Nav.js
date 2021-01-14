import React, {Component} from 'react';
import '../css/Nav.css'
import withRouter from "react-router-dom/es/withRouter";

class Nav extends Component{

    render(){
        return(
            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <a className="navbar-brand brand" href="/">TEST SPRING</a>
                </nav>
            </div>
        )
    }
}

export default withRouter(Nav);