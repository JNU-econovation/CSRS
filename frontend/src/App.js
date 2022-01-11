import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'index.css';
import Splash from 'pages/Splash';
import Main from 'pages/Main';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Splash />}></Route>
        <Route path="/main" element={<Main />}></Route>
      </Routes>
    </Router>
  );
}

export default App;
