import './App.css';
import {
    ToastContainer,toast
} from "react-toastify";
import Header from "./components/header";
import AllArtists from "./components/AllArtists"
import AddArtist from "./components/AddArtist";
import Options from "./components/Options";
import {Col, Container, Row} from "reactstrap";
import Home from "./components/home";
import { BrowserRouter as Router, Switch, Route, Link} from "react-router-dom";

function App() {

  return(

     <div>
         <Router>
         <ToastContainer />
         <Container>
             <Header />
             <Row>
                 <Col md={4}>
                     <Options />
                 </Col>
                 <Col md={8}>
                     <Route path={'/'} component={Home} exact/>
                     <Route path={'/add-artist'} component={AddArtist} exact/>
                     <Route path={'/all-artists'} component={AllArtists} exact/>
                 </Col>
             </Row>
         </Container>
         </Router>
     </div>

  );
}

export default App;
