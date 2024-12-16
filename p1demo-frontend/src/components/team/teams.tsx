import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Container, Table } from "react-bootstrap";

// interface  to model team object
interface Team {
    teamId: number,
    teamName: String,
    teamLocation: String,
}

function Teams() {

    // We will store state object, that stores array of team object
    // this will get filled after get request
    const [teams, setTeams] = useState<Team[]>([]);

    // TODO: useEffect to send GetRequest for teams on component load
    useEffect(() => {
        getAllTeams();
    }, []); // useEffect will trigger once on component load


    // The function that sends the GET request
    const getAllTeams = async () => {

        // axios get request
        const response = await axios.get("http://localhost:4444/teams")

        // populate state object;
        setTeams(response.data);
        console.log(response.data);
    }

    return (
        <Container>
            <h3> Teams </h3>
            <Table>
                <thead>
                    <tr>
                        <th> ID</th>
                        <th> Name</th>
                        <th> Location</th>
                        <th> Count </th>
                        <th> Options </th>
                    </tr>
                </thead>
                <tbody>
                    {teams.map((team, index) => (
                        <tr>
                            <td>{team.teamId}</td>
                            <td>{team.teamName}</td>
                            <td>{team.teamLocation}</td>
                            <td>{index}</td>
                            <td>
                                <Button className="btn btn-danger"> Delete </Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Container>
    );
}

export default Teams;