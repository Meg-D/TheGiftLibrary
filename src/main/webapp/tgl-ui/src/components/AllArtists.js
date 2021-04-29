import React, { useState, useEffect } from 'react';
import Artist from "./Artist";
import {Button} from "reactstrap";
import base_url from "../api/bootapi";
import axios from "axios";
import {toast} from 'react-toastify';

const AllArtists = () => {

    useEffect(() => {
        document.title="all artists";
    },[]);

    //function to call server;
    const getAllArtistsFromServer=()=>{
        axios.get(`${base_url}/artists`).then(
            (response)=>{
                console.log(response.data);
                toast.success("artists has been loaded",{
                    position: "bottom-center",
                });
                setArtists(response.data);
            },
            (error)=>{
                console.log(error);
                toast.error("something went wrong",{position: "bottom-center",}
                    );
            }
        )
    }

    useEffect(() => {
        getAllArtistsFromServer()
    },[]);

    const [artists,setArtists] = useState([
    ])

    return(
        <div>

            <h1>All artists</h1>
            <p>list of artists are given:</p>
            {
                artists.length>0
                    ? artists.map((item)=> <Artist key={item.name} artist={item}/>)
                    : "No artists"
            }

        </div>
    );
};

export default AllArtists;