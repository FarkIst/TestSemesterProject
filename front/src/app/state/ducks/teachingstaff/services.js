require('es6-promise').polyfill();
require('isomorphic-fetch');

const getTeachingstaff = () => {
  fetch(process.env.API + 'teachingstaff').then(function(response) {
    if (response.status >= 400) {
      throw new Error('Bad request');
    }
    return response.json();
  });
};

export { getTeachingstaff };
