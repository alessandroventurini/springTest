import React, {Component} from 'react';
import Nav from "./Nav";


class Login extends Component{

    state = {
        username: '',
        password:'',
        error: ''
    }

    onChange = (key,value) =>{
        this.setState({[key]:value});
    }
    componentDidMount() {
        debugger;
        if(this.props.error){
            this.showError();
        }
    }

    showError = (err) => {
        this.onChange('error',err);
        document.getElementById('alert').className = 'alert alert-warning alert-dismissible fade show';
    }

    signIn = (event) =>{
        debugger;
        event.preventDefault();
        const data = new FormData(this.form);
        fetch(this.form.action, {
            method: this.form.method,
            body: new URLSearchParams(data)
        })
            .then(v =>{
                debugger;
                console.log(v.redirected + " " + v.url);
                if(v.redirected) {
                        window.location = v.url;
                }
            })
            .catch(e => console.error(e))

    }

    render() {
        return(
            <div>
                <Nav type={"login"}/>
                <div className='container center_div'>
                    <h1>LOGIN</h1>
                    <form onSubmit={this.signIn} action={"/perform_login"} ref={fm => {this.form=fm}} method={"POST"}>
                        <div className='input-group mb-3'>
                            <span className="input-group-text">Username</span>
                            <input type="text" className='form-control' name="username" placeholder={'Username'} onChange={event => this.onChange('username',event.target.value)}/>
                        </div>
                        <div className="input-group mb-3">
                            <span className="input-group-text">Password</span>
                            <input type="password" className='form-control' name="password" placeholder={'password'} onChange={event => this.onChange('password',event.target.value)}/>
                        </div>
                        <div className="alert alert-warning alert-dismissible fade close" role="alert" id={'alert'}>
                            {this.props.error}
                        </div>
                        <button type="submit" className='btn btn-dark'>LOGIN</button>
                    </form>

                </div>
            </div>

        )
    }

}

export default Login