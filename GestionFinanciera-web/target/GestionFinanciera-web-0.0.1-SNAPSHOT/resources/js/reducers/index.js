import { combineReducers } from 'redux';
import { showUsers } from '/users'

export default const rootReducer = combineReducers({
  user: showUsers
});