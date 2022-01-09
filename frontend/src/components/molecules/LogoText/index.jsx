import React from 'react';

import * as Styled from './style';

function LogoText({ size, children }) {
  return <Styled.LogoText size={size}>{children}</Styled.LogoText>;
}

export default LogoText;
