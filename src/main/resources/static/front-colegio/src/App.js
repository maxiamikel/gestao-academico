import './App.css';
import './styles.css';
import Footer from './components/Footer';
import Formulario from './components/Fornulario';
import Header from './components/Header';
import Tabela from './components/Tabela';

function App() {
  return (
    <div className="App">
      <Header />
      <Formulario />
      <Tabela />
      <Footer />
    </div>
  );
}

export default App;
