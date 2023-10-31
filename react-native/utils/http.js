import axios from 'axios';

const BACKEND_URL = 'http://localhost:8080';

export async function getNotice() {
  const result = await axios
    .get(BACKEND_URL + '/notice')
    .catch(e => console.log(e));
  const rst = [];
  // console.log(result['data']);
  for (const data of result['data']) {
    // console.log(data);
    rst.push({
      id: data['numId'],
      title: data['title'],
      url: data['url'],
      createdAt: data['createdAt'],
    });
  }
  // console.log(rst);
  return rst;
}

export async function postReservation(data) {
  console.log(BACKEND_URL);
  const result = await axios.post(BACKEND_URL + '/reservation', data);
  return result;
}

export async function updateReservation(data) {
  const result = await axios.post(BACKEND_URL + '/reservation/status', data);
  return result;
}

export async function getReservation() {
  const result = await axios.get(BACKEND_URL + '/reservation');
  const rst = [];
  for (const data of result['data']) {
    let status;
    if (data['status'] === 0) {
      status = '대기중';
    } else if (data['status'] === 1) {
      status = '승인';
    } else {
      status = '거절';
    }
    rst.push({
      id: data['id'],
      date: data['date'],
      startTime: data['startTime'],
      endTime: data['endTime'],
      number: data['number'],
      status: status,
    });
  }
  return rst;
}
