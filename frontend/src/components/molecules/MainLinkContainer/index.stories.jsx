import React from 'react';
import MainLinkContainer from '.';

export default {
  title: 'Molecules / MainLinkContainer'
};

export const container = () => {
  return (
    <MainLinkContainer
      title={'작품 등록'}
      subtitle={'창작물을 경매에 등록해보세요'}
      alt={'작품등록'}
      to={'/register'}
      link={'작품등록'}
    />
  );
};
