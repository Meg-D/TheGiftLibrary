import React from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container
} from 'reactstrap';

const Artist=({ artist })=>{

    return(
    <Card>
        <CardImg top width="100%" src={artist.photo} alt="Card image cap" />
        <CardBody className="text-center">
            <CardTitle className="font-weight-bold">{artist.name}</CardTitle>
            <CardSubtitle>{artist.email} <br/>{artist.website}<br/> {artist.number}</CardSubtitle>
            <CardText>{artist.about}</CardText>
            <Container>
                <Button color={"primary"}>Select</Button>
            </Container>
        </CardBody>
    </Card>
    )
}


export default Artist;