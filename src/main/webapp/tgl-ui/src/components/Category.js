import React from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container
} from 'reactstrap';

const Category=({ category })=>{

    return(
        <Card>
            <CardImg top width="100%" alt="Card image cap" />
            <CardBody className="text-center">
                <CardTitle className="font-weight-bold">{category.name}</CardTitle>
                <CardText>{category.about}</CardText>
                <Container>
                    <Button color={"primary"}>Select</Button>
                    <Button color={"success"}>Update</Button>
                    <Button color={"danger"}>Delete</Button>
                </Container>
            </CardBody>
        </Card>
    )
}


export default Category;