import React, {Component} from 'react';
import '../css/Nav.css'

class Nav extends Component{


    logout = () =>{
        console.log("ciao");
        fetch("/perform_logout")
            .then(v =>{
                debugger;
                console.log(v.redirected + " " + v.url);
                if(v.redirected) {
                    window.location = v.url;
                }
            })
            .catch(e => console.error(e))
    }

    render(){
        return(
            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                    <a className="navbar-brand brand" href="/">TEST SPRING</a>
                    <div className="nav navbar-right logout">
                        {this.props.type == "logged" && (
                            <button className="btn btn-outline-light" onClick={this.logout}>LOGOUT</button>
                        )}
                    </div>
                </nav>
            </div>
        )
    }
}

export default Nav;