import React, {Component} from 'react';
import Form from "./Form";
import withRouter from "react-router-dom/es/withRouter";


class Login extends Component{

    state = {
        email: '',
        password:''
    }

    render() {
        return(
            <Form type={'login'}/>
        )
    }

}

export default withRouter(Login);