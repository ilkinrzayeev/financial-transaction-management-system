import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CustomerPage from './pages/CustomerPage';

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/customers" element={<CustomerPage />} />
          <Route path="/" element={<CustomerPage />} />
        </Routes>
      </Router>
  );
}

export default App;