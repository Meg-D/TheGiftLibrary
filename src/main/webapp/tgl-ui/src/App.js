import './App.css';
import {
    ToastContainer,toast
} from "react-toastify";
import Header from "./components/header";
import AllArtists from "./components/AllArtists"
import AddArtist from "./components/AddArtist";
import Artists_Options from "./components/Artists-Options";
import {Col, Container, Row} from "reactstrap";
import Home from "./components/home";
import { BrowserRouter as Router, Switch, Route, Link} from "react-router-dom";
import Categories_Options from "./components/Categories-Options";
import AllCategories from "./components/AllCategory";
import AddCategory from "./components/AddCategory"
import Products_Options from "./components/Products-Options";
import AddProduct from "./components/AddProduct";
import AllProducts from "./components/AllProducts";
import Admin_Options from "./components/Admin-Options";
import AllArtistRequests from "./components/AllArtistRequests";
import AllCategoryRequests from "./components/AllCategoryRequests";

function App() {

  return(

     <div>
         <Router>
         <ToastContainer />
         <Container>
             <Header />
             <Row>
                 <Col md={4}>
                     <Route path={'/Admin-Options'} component={Admin_Options}/>
                     {/*<Route path={'/Categories-Options'} component={Categories_Options}/>*/}
                     {/*<Route path={'/Products-Options'} component={Products_Options}/>*/}
                 </Col>
                 <Col md={8}>
                     <Route path={'/Admin-Options/add-artist'} component={AddArtist} exact/>
                     <Route path={'/Admin-Options/all-artists'} component={AllArtists} exact/>
                     <Route path={'/Admin-Options/add-category'} component={AddCategory} exact/>
                     <Route path={'/Admin-Options/all-categories'} component={AllCategories} exact/>
                     <Route path={'/Admin-Options/all-artist-requests'} component={AllArtistRequests} exact/>
                     <Route path={'/Admin-Options/all-category-requests'} component={AllCategoryRequests} exact/>
                     <Route path={'Admin-Options/all-products'} component={AllProducts} exact/>
                 </Col>
             </Row>
         </Container>
         </Router>
     </div>

  );
}

export default App;
