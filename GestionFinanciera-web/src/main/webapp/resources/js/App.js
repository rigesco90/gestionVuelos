var Vuelo = React.createClass({
  render: function() {
    return (<div>vuelo</div>);
  }
});
var EmployeeTable = React.createClass({
  render: function() {
    return (<div> employeetable </div>);
  }
});

var Vuelo = React.createClass({
  render: function() {
    return (
      <tr>
        <td>{this.props.vuelo.cliente.nombres}</td>
        <td>{this.props.vuelo.cliente.apellidos}</td>
        <td>{this.props.vuelo.cliente.identificacion}</td>
        <td>{this.props.vuelo.cliente.direccion}</td>
        <td>{this.props.vuelo.cliente.telefono}</td>
        <td>{this.props.vuelo.valor}</td>
        <td>{this.props.vuelo.fechaSalida}</td>
        <td>{this.props.vuelo.fechaLlegada}</td>
      </tr>);
  }
});

var EmployeeTable = React.createClass({
  render: function() {
    var rows = [];
    this.props.vuelos.forEach(function(vuelo) {
      rows.push(<Vuelo vuelo={vuelo} />);
    });
    return (
		<div className="container">
  <table className="table table-striped">
    <thead>
      <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Numero de identificacion</th>
        <th>Direccion</th>
        <th>Telefono</th>
        <th>Valor Tiquete</th>
        <th>Fecha de salida</th>
        <th>Fecha de regreeso</th>
      </tr>
    </thead>
    <tbody>{rows}</tbody>
  </table>
</div>
      );
  }
});

    var App = React.createClass({
    	 
    	  loadEmployeesFromServer: function () {
    	    var self = this;
    	    $.ajax({
    	      url: "http://localhost:8080/rest/WSRestReservas/listReservas"
    	    }).then(function (data) {
    	      self.setState({vuelos: data});
    	    });
    	  },
    	 
    	  getInitialState: function () {
    	    return {vuelos: []};
    	  },
    	 
    	  componentDidMount: function () {
    	    this.loadEmployeesFromServer();
    	  },
    	 
    	  render() {
    	    return ( <EmployeeTable vuelos={this.state.vuelos}/> );
    	  }
    	});
    	    
    ReactDOM.render(<App />, document.getElementById('root') );