import React from 'react'
import { ListGroup } from 'reactstrap';
import { Link } from "react-router-dom";


const Options=()=>{
    return (
        <ListGroup>
            <Link className="list-group-item list-group-item-action" tag="a" to="/" action>Home</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/add-artist" action>Add Artist</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/all-artists" action>All Artist</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Delete Artist</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Log Out</Link>
        </ListGroup>
    )
}

export default Options;