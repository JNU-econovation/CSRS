import React from 'react';
import SpalshTemplate from './template';

import Guide from 'components/organisms/Guide';

function Splash() {
  return <SpalshTemplate guide={<Guide />}></SpalshTemplate>;
}

export default Splash;
