import React from 'react';
import { Router } from 'react-router-dom';
import Guide from '.';
export default {
  title: 'organisms / Guide'
};

export const HomeSplash = () => {
  return (
    <Router>
      <Guide></Guide>
    </Router>
  );
};
