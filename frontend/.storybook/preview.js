import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

export const parameters = {
  actions: { argTypesRegex: '^on[A-Z].*' },
  controls: {
    matchers: {
      color: /(background|color)$/i,
      date: /Date$/
    }
  }
};
export const decorators = [
  (Story) => (
    <Router>
      <Routes>
        <Route path="*" element={<Story />} />
      </Routes>
    </Router>
  )
];
