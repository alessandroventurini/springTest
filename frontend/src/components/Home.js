import React, {Component} from 'react';


class Home extends Component{


    onChange = (key,value) =>{
        this.setState({[key]:value});
    }

    getRestResponse = (service) =>{
        fetch(service, {
            method: "GET"
        })
            .then(v =>{
                console.log(v);
            })
            .catch(e => console.error(e))
    }

    render() {
        return(
            <div>
                <div className='api_call'>
                    <h1>REST CALL</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <button className='btn btn-dark' onClick={() => this.getRestResponse("/posts")}>Get Posts</button>
                                </td>
                                <td>
                                    <button className='btn btn-dark' onClick={() => this.getRestResponse("/comments")}>Get Comments</button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <textarea rows={"20"} cols={"40"} id={"getPostResult"}/>
                                </td>
                                <td>
                                    <textarea rows={"20"} cols={"40"} id={"getCommentsResult"}/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>


        )
    }

}

export default Home;