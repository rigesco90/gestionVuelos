var Employee = React.createClass({
  render: function() {
    return (<div>employee</div>);
  }
});
var EmployeeTable = React.createClass({
  render: function() {
    return (<div> employeetable </div>);
  }
});

var Employee = React.createClass({
  render: function() {
    return (
      <tr>
        <td>{this.props.employee.apellidos}</td>
        <td>{this.props.employee.direccion}</td>
        <td>{this.props.employee.identificacion}</td>
        <td>{this.props.employee.nombres}</td>
        <td>{this.props.employee.telefono}</td>
      </tr>);
  }
});

var EmployeeTable = React.createClass({
  render: function() {
    var rows = [];
    this.props.employees.forEach(function(employee) {
      rows.push(<Employee employee={employee} />);
    });
    return (
		<div className="container">
  <table className="table table-striped">
    <thead>
      <tr>
        <th>nombres</th>
        <th>apellidos</th>
        <th>identificacion</th>
        <th>direccion</th>
        <th>telefono</th>
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
    	      self.setState({employees: data});
    	    });
    	  },
    	 
    	  getInitialState: function () {
    	    return {employees: []};
    	  },
    	 
    	  componentDidMount: function () {
    	    this.loadEmployeesFromServer();
    	  },
    	 
    	  render() {
    	    return ( <EmployeeTable employees={this.state.employees}/> );
    	  }
    	});
    	    
    ReactDOM.render(<App />, document.getElementById('root') );