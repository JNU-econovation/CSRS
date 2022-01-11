import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'index.css';
import Splash from 'pages/Splash';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Splash />}></Route>
      </Routes>
    </Router>
  );
}

export default App;
