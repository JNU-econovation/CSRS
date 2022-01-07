import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'index.css';
import NavBar from 'components/organisms/NavBar';
function App() {
  return (
    <Router>
      <NavBar></NavBar>
      <Routes>
        <Route></Route>
      </Routes>
    </Router>
  );
}

export default App;
