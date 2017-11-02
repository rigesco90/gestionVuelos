import axios from 'axios'

export const SHOW_USERS = 'SHOW_USERS'

export function showUsers() {
    
    return (dispatch, getState) => {
        axios.get('http://localhost:8080/rest/WSRestCliente/listClients')
            .then((response) => {
                dispatch( { type: SHOW_USERS, payload: response.data } ) 
            }) 
    }
    
} 
