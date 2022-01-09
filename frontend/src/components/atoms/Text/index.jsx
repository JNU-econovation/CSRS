import React from 'react';

import * as S from './style';

function Text({ className, children }) {
  return <S.Text className={className}>{children}</S.Text>;
}

export default Text;
