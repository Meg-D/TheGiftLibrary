import React from 'react'
import { ListGroup } from 'reactstrap';
import { Link } from "react-router-dom";


const Products_Options=()=>{
    return (
        <ListGroup>
            <Link className="list-group-item list-group-item-action" tag="a" to="/" action>Home</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/Products-Options/add-product" action>Add Product</Link>
            <Link className="list-group-item list-group-item-action" tag="a" to="/Products-Options/all-products" action>All Products</Link>
            {/*<Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Delete Artist</Link>*/}
            <Link className="list-group-item list-group-item-action" tag="a" to="#!" action>Log Out</Link>
        </ListGroup>
    )
}

export default Products_Options;