import React from 'react';

import * as Styled from './style';

function LogoText({ children, ...props }) {
  return <Styled.LogoText {...props}>{children}</Styled.LogoText>;
}

export default LogoText;
