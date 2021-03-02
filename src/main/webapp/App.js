import Header from './components/Header/Header';
import Main from './components/Main/Main';
import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import ChatPage from './components/ChatPage/ChatPage';
import DiscoverPage from './components/DiscoverPage/DiscoverPage';
import ProjectsPage from './components/ProjectsPage/ProjectsPage';
import ProfilePage from './components/ProfilePage/ProfilePage';
import LoginPage from './components/LoginPage/LoginPage';
import useToken from './hooks/useToken';

function App() {

  const { token, setToken } = useToken();

  if(!token) {
    return <LoginPage setToken={setToken} />
  }

  return (
    <Router>
      { window.location.pathname!=='/login' ? <Header setToken={setToken}/> : null }
      <Route path="/" exact component={Main}/>
      <Route path="/discover" component={DiscoverPage}/>
      <Route path="/projects" component={ProjectsPage}/>
      <Route path="/chat" component={ChatPage}/>
      <Route path="/profile" component={ProfilePage}/>
      <Route path="/login" component={LoginPage}/>
    </Router>
  );
}

export default App;
