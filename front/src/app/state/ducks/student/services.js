require('es6-promise').polyfill();
require('isomorphic-fetch');

const getStudents = () => {
  fetch(process.env.API + 'students').then(function(response) {
    if (response.status >= 400) {
      throw new Error('Bad request');
    }
    return response.json();
  });
};

export { getStudents };
