import React from 'react'
import { Navbar, Container,Nav } from 'react-bootstrap'
import { Link, Outlet } from 'react-router-dom'
const NavbarComp = () => {
  return (
    <div>
        <Navbar bg="light" expand="lg">
            <Container fluid>
                <Navbar.Brand>EASY SEA</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav>
                        <Nav.Item as={Link} to='/'>User</Nav.Item>
                        <Nav.Item as={Link} to='/home'>Home</Nav.Item>
                        <Nav.Link as={Link} to='/favs'>Favs</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
        <Outlet/>
    </div>
  )
}

export default NavbarComp