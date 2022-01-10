import Img from 'components/atoms/Img';
import React from 'react';

import * as Styled from './style';

function ImgBtn({ category, src, alt, width, ...props }) {
  if (category) {
    return (
      <Styled.Button {...props}>
        <Img alt={alt} src={src} />
        <Styled.Category> {category}</Styled.Category>
      </Styled.Button>
    );
  }
  return (
    <Styled.Button {...props} width={width}>
      <Img alt={alt} src={src} />
    </Styled.Button>
  );
}

export default ImgBtn;
