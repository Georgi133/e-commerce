import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Dropdown  from 'react-bootstrap/Dropdown';
import DropdownButton  from 'react-bootstrap/DropdownButton';
import { BsCart3, BsPersonCircle, BsSearch } from 'react-icons/bs';
import { useState } from 'react';
import Sign from '../UserSigning/Sign';

function NavbarComponent() {
  const [sign, setSign] = useState(false);

  return (
    <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container fluid className="d-flex justify-content-between" style={{ width: "100%"}}>
        <div className="d-flex align-items-center gap-3">
            <Navbar.Brand href="/" className="fw-bold fs-4 text-dark-emphasis" style={{ padding: "3%", transform: "rotate(3deg)" }}>Online Shop</Navbar.Brand>
            <Dropdown>
                <Dropdown.Toggle id="dropdown-button-light-example1" variant="light">
                Categories
                </Dropdown.Toggle>

                <Dropdown.Menu>
                  <Dropdown.Item href="#/action-1" active>None</Dropdown.Item>
                  <Dropdown.Item href="#/action-2">Men's Clothing</Dropdown.Item>
                  <Dropdown.Item href="#/action-3">Women's Clothing</Dropdown.Item>
                  <Dropdown.Item href="#/action-4">Children's Clothing</Dropdown.Item>
                <Dropdown.Divider />
                <Dropdown.Item href="#/action-5">Accessories</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
            <DropdownButton id="dropdown-button-dark-example1" variant="light" title="Filter">
              <Dropdown.Item href="#/action-1" active>Most Popular</Dropdown.Item>
              <Dropdown.Item href="#/action-2">Price: Low to High</Dropdown.Item>   
              <Dropdown.Item href="#/action-3">Price: High to Low</Dropdown.Item>
              <Dropdown.Item href="#/action-4">Biggest Discount</Dropdown.Item>
            </DropdownButton>

        </div>
        <div>
            <Form className="d-flex me-3">
            <div style={{ position: 'relative' }}>
              <Form.Control
                type="search"
                placeholder="Search for products"
                aria-label="Search"
                style={{ paddingRight: '2rem' }}
              />
              <BsSearch onClick={ () => console.log('Search clicked') } size={16} style={{ position: 'absolute', right: '0.6rem', top: '50%', transform: 'translateY(-50%)', pointerEvents: 'auto', cursor: 'pointer', color: '#6c757d'}} />
            </div>
          </Form>
        </div>
        <div>

            <Nav className="ms-auto d-flex flex-row align-items-center gap-3">
                <Nav.Link href="/cart" className="d-flex align-items-center gap-1">
                    <BsCart3 size={20} />
                </Nav.Link>
                <Nav.Link onClick = {() => setSign(!sign)} className="d-flex align-items-center gap-1">
                    <BsPersonCircle size={20} />
                </Nav.Link>
            </Nav>
        </div>

      </Container>
    </Navbar>
    <Sign show={sign} onClose={() => setSign(false)} />
    </>
  );
}

export { NavbarComponent as Navbar };