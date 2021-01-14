import React, {Component} from 'react';
import '../css/Nav.css'

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

export default Nav;