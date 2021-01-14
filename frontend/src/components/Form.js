import React, {Component} from 'react';
import withRouter from "react-router-dom/es/withRouter";


class Form extends Component{

    state = {
        email: '',
        password:'',
        error: ''
    }

    onChange = (key,value) =>{
        this.setState({[key]:value});
    }

    setTitle = () =>{
        return this.props.type === 'signup' ? 'SIGN UP' : 'LOGIN';
    }

    chooseFunction = () =>{
        this.props.type === 'signup' ? this.signUp() : this.signIn();
    }

    signUp = () =>{
    }

    showError = (err) => {
        this.onChange('error',err.toString());
        document.getElementById('alert').className = 'alert alert-warning alert-dismissible fade show';
    }

    signIn = () =>{
    }

    render() {
        return(
            <div className='container center_div'>
                <h1>{this.setTitle()}</h1>
                <div>
                    <div className='input-group mb-3'>
                        <span className="input-group-text">Email</span>
                        <input type="text" className='form-control' placeholder={'Email'} onChange={event => this.onChange('email',event.target.value)}/>
                    </div>
                    <div className="input-group mb-3">
                        <span className="input-group-text">Password</span>
                        <input type="password" className='form-control' placeholder={'password'} onChange={event => this.onChange('password',event.target.value)}/>
                    </div>
                    <div className="alert alert-warning alert-dismissible fade close" role="alert" id={'alert'}>
                        {this.state.error}
                    </div>
                    <button className='btn btn-dark' onClick={this.chooseFunction}>{this.setTitle().toUpperCase()}</button>
                </div>

            </div>
        )
    }

}

export default withRouter(Form);