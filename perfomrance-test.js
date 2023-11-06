import http from 'k6/http';
import { sleep } from 'k6';

export const options = {

  stages: [
    { duration: '5m', target: 2 }

  ],
};

export default () => {
    const backendUrl = 'http://192.168.33.10:8082';
  const backendResponse = http.get(backendUrl);


  const frontendUrl = 'http://192.168.33.10:8088';
  const frontendResponse = http.get(frontendUrl);

  sleep(1);

};
