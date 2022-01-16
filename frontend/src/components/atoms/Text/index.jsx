import React from 'react';

import * as S from './style';

function Text({ className, bold, children }) {
  return (
    <S.Text className={className} bold={bold}>
      {children}
    </S.Text>
  );
}

export default Text;
