import React from 'react'
import { ListGroup } from 'reactstrap';
import { Link } from "react-router-dom";


const Categories_Options=()=>{
    return (
        <ListGroup>
            <Link className="list-group-item list-group-item-action" tag="a" to="/" action>Home</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/Categories-Options/add-category" action>Add Category</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/Categories-Options/all-categories" action>All Categories</Link>
            {/*<Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Delete Artist</Link>*/}
            <Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Log Out</Link>
        </ListGroup>
    )
}

export default Categories_Options;