import React, {Component} from 'react';
import axios from 'axios';
import Nav from "./Nav";


class Home extends Component{

    state = {
        posts: '',
        comments: [],
        userId: '',
        id : ''
    }

    componentDidMount() {
        debugger;
        axios
            .get('/getUser')
            .then((response) =>{
                debugger;
                console.log(response.data);
                this.setState({userId: response.data.username})
                this.setState({id: response.data.id})
            })
            .catch((error)=>{
                debugger;
                console.log(error);
            });
    }

    onChange = (key,value) =>{
        this.setState({[key]:value});
    }

    getRestResponse = (service,type) =>{
        debugger;
        this.clearView(type);
        axios
            .get(service.concat(this.state.id))
            .then((response) =>{
                debugger;
                console.log(response.data);
                this.onChange(type,response.data);
            })
            .catch((error)=>{
                debugger;
                console.log(error);
            });
    }

    clearView = (type) =>{
        if(type === "comments"){
            this.setState({posts: ''})
        }
        else{
            this.setState({comments: []})
        }
    }

    render() {
        return(
            <div>
                <Nav type={"logged"}/>
                <div className='api_call'>
                    <h1>POST & COMMENTI di {this.state.userId.toUpperCase()}</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <button className='btn btn-dark' onClick={() => this.getRestResponse("/getPosts/","posts")}>Get Posts</button>
                                </td>
                                <td>
                                    <button className='btn btn-dark' onClick={() => this.getRestResponse("/getComments/","comments")}>Get Comments</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table>
                        <tbody>
                        <tr>
                            {
                                this.state.posts && (
                                    <td>
                                        <div className="card border-dark  mb-3 customCard">
                                            <div className="card-body text-dark">
                                                <h5 className="card-title">{this.state.posts.title}</h5>
                                                <p className="card-text">{this.state.posts.body}</p>
                                            </div>
                                        </div>
                                    </td>
                                )
                            }
                        </tr>
                        <tr>
                            {
                                this.state.comments.map((comment) =>(
                                    <td>
                                        <div className="card border-secondary mb-3 customCard">
                                            <div className="card-header">{comment.email}</div>
                                            <div className="card-body text-secondary">
                                                <h5 className="card-title">{comment.name}</h5>
                                                <p className="card-text">{comment.body}</p>
                                            </div>
                                        </div>
                                    </td>
                                ))
                            }
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


        )
    }

}

export default Home;