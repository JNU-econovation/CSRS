import React from 'react';

import * as Styled from './style';

function ImgBtn({ src, alt, width, ...props }) {
  return (
    <Styled.Button {...props} width={width}>
      <Styled.Image alt={alt} src={src} />
    </Styled.Button>
  );
}

export default ImgBtn;
