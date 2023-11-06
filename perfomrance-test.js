import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
  vus: 10,              
  stages: [
    { duration: '30s', target: 10 },  
    { duration: '1m', target: 10 },   
    { duration: '30s', target: 0 }, 
  ],
};

export default () => {
    const backendUrl = 'http://192.168.33.10:8082/product';
  const backendResponse = http.get(backendUrl);


  const frontendUrl = 'http://192.168.33.10:8088/products';
  const frontendResponse = http.get(frontendUrl);

  sleep(1);

};
