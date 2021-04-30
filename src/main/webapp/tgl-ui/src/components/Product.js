import React from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container
} from 'reactstrap';

const Product=({ product })=>{

    return(
        <Card>
            <CardImg top width="100%" alt="Card image cap" />
            <CardBody className="text-center">
                <CardTitle className="font-weight-bold">{product.name}</CardTitle>
                <CardSubtitle>{product.price} <br/>
                {/*<br/> {product.art_id.name}*/}
                </CardSubtitle>
                <CardText>{product.description}</CardText>
                <Container>
                    <Button color={"primary"}>Select</Button>
                    <Button color={"success"}>Update</Button>
                    <Button color={"danger"}>Delete</Button>
                </Container>
            </CardBody>
        </Card>
    )
}


export default Product;